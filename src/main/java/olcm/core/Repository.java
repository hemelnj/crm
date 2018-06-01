/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olcm.core;
import java.util.List;
public interface Repository <T> {
    public void create(T entity);

    public void update(T entity);

    public void delete(T entity);
    
    public T read(Object id);

    public List<T> readAll();

    public List<T> readRange(int[] range);

    public int count();
}
