package main.java;

import java.util.*;

    /**
     * Singleton object used to contain mls objects (JVM scope)
     */
    public class  Singleton {

        //only one constructor ... private default constructor ... why?: avoid public instantiation
        private Singleton() {
        }

        public final static int MAX_CACHE_SIZE = 5000000;

        //static instance of the class
        private static volatile Singleton instance = null;

        //underlying map object
        private static Map<UUID, RealEstate> storage;
        private static Map<UUID, RealEstate> cache;

        /**
         * getInstance to get a reference to the singleton class
         *
         * @return the Singleton that allows storing of the shapes
         */
        public static Singleton getInstance() {
            //if instance is created, no need to creat a new one
            if (null == instance) {
                //double clutching to assure no issues with other threads (locking on the class itself)
                synchronized (Singleton.class) {
                    if (null == instance) {
                        instance = new Singleton();
                        storage = new LinkedHashMap<>() {
                            @Override
                            protected boolean removeEldestEntry(final Map.Entry old) {
                                return size() > MAX_CACHE_SIZE;
                            }
                        };
                        cache = Collections.synchronizedMap(storage);
                    }
                }
            }
            return instance;
        }

        /**
         * to assign a listing to an id and then store it in the cache
         * @param mlsId a universally unique identifier (UUID).
         * @param property a listing that has an id, address and price.
         */
        public void mlsUpdate(UUID mlsId, RealEstate property) {
            cache.put(mlsId, property);
        }

        /**
         * to get all the listings
         * @return a list of all the realestates
         */
        public List<RealEstate> mlsRead(){
            return cache.values().stream().toList();
        }

        /**
         * to delete a listing
         * @param mldId a universally unique identifier (UUID).
         */
        public void mlsDelete(UUID mldId){
            cache.remove(mldId);
        }
        /**
         * to get information about a listing, such as uuid,address and price.
         * @param mlsId a universally unique identifier (UUID).
         * @return information on a listing.
         */
        public RealEstate mlsGet(UUID mlsId) {
            RealEstate record = cache.getOrDefault(mlsId, null);
            return record;

        }
        public void Clear(){
            cache.clear();
        }
}
