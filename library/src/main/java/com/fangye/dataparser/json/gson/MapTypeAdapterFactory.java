/*
 * Copyright (C) 2011 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fangye.dataparser.json.gson;


import com.fangye.dataparser.json.CommonJsonBuilder;
import com.fangye.dataparser.utils.LogTagsUtils;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 自定义对象map解析适配器 。
 *
 * @Package: com.fangye.dataparser.json.gson
 * @Author: fanyeren51@gmail.com
 * @UpdateDate: 2020/05/04 18:10
 */
public final class MapTypeAdapterFactory implements TypeAdapterFactory {
  private final ConstructorConstructor constructorConstructor;
  final boolean complexMapKeySerialization;

  public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor,
                               boolean complexMapKeySerialization) {
    this.constructorConstructor = constructorConstructor;
    this.complexMapKeySerialization = complexMapKeySerialization;
  }

  @Override public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
    Type type = typeToken.getType();

    Class<? super T> rawType = typeToken.getRawType();
    if (!Map.class.isAssignableFrom(rawType)) {
      return null;
    }

    Class<?> rawTypeOfSrc = $Gson$Types.getRawType(type);
    Type[] keyAndValueTypes = $Gson$Types.getMapKeyAndValueTypes(type, rawTypeOfSrc);
    TypeAdapter<?> keyAdapter = getKeyAdapter(gson, keyAndValueTypes[0]);
    TypeAdapter<?> valueAdapter = gson.getAdapter(TypeToken.get(keyAndValueTypes[1]));
    ObjectConstructor<T> constructor = constructorConstructor.get(typeToken);

    @SuppressWarnings({"unchecked", "rawtypes"})
    // we don't define a type parameter for the key or value types
    TypeAdapter<T> result = new Adapter(gson, keyAndValueTypes[0], keyAdapter,
        keyAndValueTypes[1], valueAdapter, constructor);
    return result;
  }

  /**
   * Returns a type adapter that writes the value as a string.
   */
  private TypeAdapter<?> getKeyAdapter(Gson context, Type keyType) {
    return (keyType == boolean.class || keyType == Boolean.class)
        ? TypeAdapters.BOOLEAN_AS_STRING
        : context.getAdapter(TypeToken.get(keyType));
  }

  private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {
    private final TypeAdapter<K> keyTypeAdapter;
    private final TypeAdapter<V> valueTypeAdapter;
    private final ObjectConstructor<? extends Map<K, V>> constructor;

    public Adapter(Gson context, Type keyType, TypeAdapter<K> keyTypeAdapter,
        Type valueType, TypeAdapter<V> valueTypeAdapter,
        ObjectConstructor<? extends Map<K, V>> constructor) {
      this.keyTypeAdapter =
        new TypeAdapterRuntimeTypeWrapper<K>(context, keyTypeAdapter, keyType);
      this.valueTypeAdapter =
        new TypeAdapterRuntimeTypeWrapper<V>(context, valueTypeAdapter, valueType);
      this.constructor = constructor;
    }

    @Override public Map<K, V> read(JsonReader in) throws IOException {
      JsonToken peek = in.peek();
      //增加判断是错误NULL的类型（应该是OBJECT）,移动in的下标到结束，移动下标的代码在下方
      if (peek == JsonToken.NULL) {
        in.nextNull();
        return constructor.construct();
      }
      //增加判断是错误NUMBER的类型（应该是OBJECT）,移动in的下标到结束，移动下标的代码在下方
      if (in.peek() == JsonToken.NUMBER) {
        in.nextDouble();
        return constructor.construct();
      }
      //增加判断是错误STRING的类型（应该是OBJECT）,移动in的下标到结束，移动下标的代码在下方
      if(peek == JsonToken.STRING){
        String value = in.nextString();
        LogTagsUtils.i("===map====value:" + value);
        if(value.startsWith("{")&&value.endsWith("}")){
          return CommonJsonBuilder.fromJson(value,new TypeToken<Map<K, V>>() { }.getType());
        }
        return constructor.construct();
      }
      //增加判断是错误NAME的类型（应该是OBJECT）,移动in的下标到结束，移动下标的代码在下方
      if (in.peek() == JsonToken.NAME) {
        in.nextName();
        return constructor.construct();
      }
      //增加判断是错误BOOLEAN的类型（应该是OBJECT）,移动in的下标到结束，移动下标的代码在下方
      if (in.peek() == JsonToken.BOOLEAN) {
        in.nextBoolean();
        return constructor.construct();
      }
      //增加判断是错误BEGIN_ARRAY的类型（应该是OBJECT）,移动in的下标到结束，移动下标的代码在下方
      if (in.peek() == JsonToken.BEGIN_ARRAY) {
        GsonUtils.readArray(in);
        LogTagsUtils.i("==7=in.peek:" + peek);
        return constructor.construct();
      }

      Map<K, V> map = constructor.construct();
      if (peek == JsonToken.BEGIN_ARRAY) {
        in.beginArray();
        while (in.hasNext()) {
          in.beginArray(); // entry array
          K key = keyTypeAdapter.read(in);
          V value = valueTypeAdapter.read(in);
          V replaced = map.put(key, value);
          if (replaced != null) {
            throw new JsonSyntaxException("duplicate key: " + key);
          }
          in.endArray();
        }
        in.endArray();
      } else {
        in.beginObject();
        while (in.hasNext()) {
          JsonReaderInternalAccess.INSTANCE.promoteNameToValue(in);
          K key = keyTypeAdapter.read(in);
          V value = valueTypeAdapter.read(in);
          V replaced = map.put(key, value);
          if (replaced != null) {
            throw new JsonSyntaxException("duplicate key: " + key);
          }
        }
        in.endObject();
      }
      return map;
    }

    @Override public void write(JsonWriter out, Map<K, V> map) throws IOException {
      if (map == null) {
        out.nullValue();
        return;
      }

      if (!complexMapKeySerialization) {
        out.beginObject();
        for (Map.Entry<K, V> entry : map.entrySet()) {
          out.name(String.valueOf(entry.getKey()));
          valueTypeAdapter.write(out, entry.getValue());
        }
        out.endObject();
        return;
      }

      boolean hasComplexKeys = false;
      List<JsonElement> keys = new ArrayList<JsonElement>(map.size());

      List<V> values = new ArrayList<V>(map.size());
      for (Map.Entry<K, V> entry : map.entrySet()) {
        JsonElement keyElement = keyTypeAdapter.toJsonTree(entry.getKey());
        keys.add(keyElement);
        values.add(entry.getValue());
        hasComplexKeys |= keyElement.isJsonArray() || keyElement.isJsonObject();
      }

      if (hasComplexKeys) {
        out.beginArray();
        for (int i = 0, size = keys.size(); i < size; i++) {
          out.beginArray(); // entry array
          Streams.write(keys.get(i), out);
          valueTypeAdapter.write(out, values.get(i));
          out.endArray();
        }
        out.endArray();
      } else {
        out.beginObject();
        for (int i = 0, size = keys.size(); i < size; i++) {
          JsonElement keyElement = keys.get(i);
          out.name(keyToString(keyElement));
          valueTypeAdapter.write(out, values.get(i));
        }
        out.endObject();
      }
    }

    private String keyToString(JsonElement keyElement) {
      if (keyElement.isJsonPrimitive()) {
        JsonPrimitive primitive = keyElement.getAsJsonPrimitive();
        if (primitive.isNumber()) {
          return String.valueOf(primitive.getAsNumber());
        } else if (primitive.isBoolean()) {
          return Boolean.toString(primitive.getAsBoolean());
        } else if (primitive.isString()) {
          return primitive.getAsString();
        } else {
          throw new AssertionError();
        }
      } else if (keyElement.isJsonNull()) {
        return "null";
      } else {
        throw new AssertionError();
      }
    }
  }
}
