package com.example.weightedexample;






import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface ProductDao {

    @Query("SELECT * FROM products where profileId=:profile_id")
    List<ProductModel> getAllProducts(int profile_id);
    @Query("SELECT COUNT(*) FROM products where profileId=:profile_id")
    int getAllcount(int profile_id);

    @Query("SELECT * FROM products where profileId=:profile_id  ORDER BY productId ASC LIMIT :limit OFFSET :offset")
    List<ProductModel> getAllProducts(int profile_id,int offset,int limit);

    @Query("SELECT productId FROM products where profileId=:profile_id  ORDER BY productId ASC LIMIT :limit OFFSET :offset")
    List<Integer> getAllProductIds(int profile_id,int offset,int limit);


    @Query("SELECT * FROM products where profileId=:profile_id and productCategoryId IN (:categoryIds)")
    List<ProductModel> getProductsOfCategory(int profile_id, List<Integer> categoryIds);

    @Query("SELECT * FROM products where profileId = :profileId and productId=:productId ")
    ProductModel selectProduct(int profileId,int productId );

    @Query("SELECT * FROM products where profileId = :profileId and (sku = :barcode OR upc = :barcode)")
    List<ProductModel> searchBarcode(int profileId, String barcode);
//
//    @Query(" SELECT productId,name,uom,sku,upc,1 as conversionrate ,1 as item,profileId,productCategoryId,description FROM products " +
//            " where profileId = :profileId and (sku = :barcode OR upc = :barcode)" +
//            " UNION" +
//            " SELECT u.productId,p.name as name,u.toUoMName as uom,p.sku as" +
//            " sku,u.upc,u.divideRate as conversionrate,2 as item,u.profileId,p.productCategoryId as productCategoryId,p.description as description  from UomConversion u" +
//            " JOIN products p on (u.productId=p.productId and u.profileId= p.profileId)" +
//            "  where (u.upc = :barcode) order by item")
//    List<ProductModel>barcodeSearch(int profileId, String barcode);

    @Query("SELECT * FROM products where profileId = :profileId and (sku like '%'||:searchText||'%' OR upc  like '%'||:searchText||'%' OR name  like '%'||:searchText||'%' OR description  like '%'||:searchText||'%')")
    List<ProductModel> searchByNameOrBarcode(int profileId, String searchText);
    @Query("SELECT * FROM products where profileId = :profileId and productCategoryId IN (:categoryIds) and (sku like '%'||:searchText||'%' OR upc  like '%'||:searchText||'%' OR name  like '%'||:searchText||'%')")
    List<ProductModel> searchByNameOrBarcode(int profileId, String searchText,List<Integer> categoryIds);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ProductModel productModel);

    @Query("DELETE FROM products where profileId=:profileId")
    void deleteAll(int profileId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<ProductModel> productModelList);

    @Delete
    void delete(ProductModel profileModel);

    @Update
    void update(ProductModel profileModel);


}
