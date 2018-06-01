/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.core;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Json {
    private GsonBuilder gsonBuilder;
    
    public Json(){
        gsonBuilder = new GsonBuilder();
        gsonBuilder.serializeNulls(); 
    }

    /**
     *
     * @param <T>
     * @param stringData
     * @param entityClass
     * @return
     * @throws IOException
     */
    /*public <T> T ConvertToObject(String stringData, Class<T> entityClass) throws IOException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.getSerializationConfig().shouldSortPropertiesAlphabetically();
            DateFormat fmt = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a", Locale.US);
            mapper.setDateFormat(fmt);
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            T solidObject = mapper.readValue(stringData, entityClass);
            return solidObject;
        }
        catch(IOException exp){
            
            throw exp;
        }
    }*/
    
    /**
     *
     * @param <T>
     * @param stringData
     * @param entityClass
     * @return
     * @throws IOException
     */
    /*Jackson Implementation will be changed to gson convertion*/
    /*public <T> List<T> ConvertToListObject(String stringData, Class<T[]> entityClass) throws IOException {
        try{
            ObjectMapper mapper = new ObjectMapper();
            List<T> solidObject = Arrays.asList(mapper.readValue(stringData, entityClass));
            return solidObject; 
        }
        catch(IOException exp){
            
            throw exp;
        }
    }*/

    /**
     *
     * @param <T>
     * @param object
     * @return
     */
    public <T> String JsonStringify(T object) {
        try {  
            Gson gson = gsonBuilder.create();
            return gson.toJson(object);

        } catch (Exception exp) {
            throw exp;
        }
    }
    
    public <T> String JsonStringify(List<T> object) {
        try {  
            Gson gson = gsonBuilder.create();
            return gson.toJson(object);

        } catch (Exception exp) {
            throw exp;
        }
    }
    
    /**
     *
     * @param incomingClass
     * @return
     * @throws IOException
     */
    /*Will be excluded*/
    /*public void ExcludeParentReferences(Class<?> incomingClass) throws IOException {
        try {
            gsonBuilder.setExclusionStrategies(new ExclusionStrategy() {  
                @Override
                public boolean shouldSkipField(FieldAttributes f) {
                    return Boolean.FALSE;
                }
                @Override
                public boolean shouldSkipClass(Class<?> incomingClass) {
                    return Boolean.TRUE;
                }
            });

        } catch (Exception exp) {
            throw exp;
        }
        //return this;
    }*/
    
    /**
     *
     * @param stringBusinessData
     * @param field
     * @return
     * @throws IOException
     */
    /*Will be renamed*/
    public String ConvertToPrimitiveType(String stringBusinessData, String field) throws IOException{
        try{
            Map jsonJavaRootObject = new Gson().fromJson(stringBusinessData, Map.class);
            return jsonJavaRootObject.get(field).toString();
        } catch (JsonSyntaxException exp) {
            throw exp;
        }
    }
}
