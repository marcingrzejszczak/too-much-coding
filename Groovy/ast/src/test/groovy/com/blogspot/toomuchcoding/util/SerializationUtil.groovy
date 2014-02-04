package com.blogspot.toomuchcoding.util

class SerializationUtil {
    static <T> T serializeAndBack(T obj) throws Exception {
        ByteArrayOutputStream os = serializeObject(obj);
        return (T) deserializeObject(os, Object.class);
    }

    static <T> T deserializeObject(ByteArrayOutputStream serialized, Class<T> type) throws IOException, ClassNotFoundException {
        InputStream unserialize = new ByteArrayInputStream(serialized.toByteArray());
        return deserializeObject(unserialize, type);
    }

    static <T> T deserializeObject(InputStream unserialize, Class<T> type) throws IOException, ClassNotFoundException {
        return new ObjectInputStream(unserialize).readObject();
    }

    static ByteArrayOutputStream serializeObject(Object object) throws IOException {
        ByteArrayOutputStream serialized = new ByteArrayOutputStream();
        new ObjectOutputStream(serialized).writeObject(object);
        return serialized;
    }
}
