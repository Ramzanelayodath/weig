package com.example.weightedexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class MainActivity : AppCompatActivity() {
    var product = "[{\"productId\":60272889,\"description\":\"Weighted kg Product\",\"name\":\"Weighted kg Product\",\"productCategoryId\":60209757,\"model\":null,\"isActive\":true,\"stockQty\":0,\"salesPrice\":10,\"priceArray\":null,\"costPrice\":10,\"productCategory\":null,\"tags\":null,\"created\":null,\"uomId\":50001,\"uom\":\"kilogram\",\"unitsPerPack\":0,\"taxCategoryID\":60200373,\"baseProductId\":0,\"sku\":null,\"upc\":\"1317\",\"group1\":null,\"group2\":null,\"webstoreFeatured\":false,\"detailedDescription\":null,\"upcType\":\"W\",\"purchased\":false,\"stocked\":false,\"sold\":false,\"poPrice\":null,\"attributeSetId\":0,\"commodityCode\":null,\"hscode\":null,\"mrpPrice\":10,\"weight\":0,\"volume\":0,\"thickness\":null,\"breadth\":null,\"length\":null,\"guaranteeDays\":0,\"cwUomId\":0,\"cwUom\":null,\"cwTolerance\":null,\"unitOfMeasure\":{\"uomid\":50001,\"name\":\"kilogram\",\"description\":null,\"isActive\":\"Y\",\"uomSymbol\":\"Kg\",\"stdPrecision\":2,\"costingPrecision\":2},\"cwUnitOfMeasure\":null,\"cwStockQty\":0,\"asiId\":0,\"classification\":null,\"productype\":null}]"
    var cwProduct = "[{\"productId\":60272468,\"description\":\"cw random\",\"name\":\"cw random\",\"productCategoryId\":60209757,\"model\":null,\"isActive\":true,\"stockQty\":0,\"salesPrice\":null,\"priceArray\":null,\"costPrice\":0,\"productCategory\":null,\"tags\":null,\"created\":null,\"uomId\":100,\"uom\":\"Each\",\"unitsPerPack\":0,\"taxCategoryID\":60200373,\"baseProductId\":0,\"sku\":null,\"upc\":\"100\",\"group1\":null,\"group2\":null,\"webstoreFeatured\":false,\"detailedDescription\":null,\"upcType\":\"N\",\"purchased\":false,\"stocked\":false,\"sold\":false,\"poPrice\":null,\"attributeSetId\":0,\"commodityCode\":null,\"hscode\":null,\"mrpPrice\":null,\"weight\":0,\"volume\":0,\"thickness\":null,\"breadth\":null,\"length\":null,\"guaranteeDays\":0,\"cwUomId\":50001,\"cwUom\":\"kilogram\",\"cwTolerance\":null,\"unitOfMeasure\":{\"uomid\":100,\"name\":\"Each\",\"description\":null,\"isActive\":\"Y\",\"uomSymbol\":\"Ea \",\"stdPrecision\":0,\"costingPrecision\":4},\"cwUnitOfMeasure\":{\"uomid\":50001,\"name\":\"kilogram\",\"description\":null,\"isActive\":\"Y\",\"uomSymbol\":\"Kg\",\"stdPrecision\":2,\"costingPrecision\":2},\"cwStockQty\":0,\"asiId\":0,\"classification\":null,\"productype\":null}]"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = Gson()
        val type: Type = object : TypeToken<List<ProductModel?>?>() {}.type
        val selectedmatchingProducts: List<ProductModel> = gson.fromJson(product, type)
        for (i in selectedmatchingProducts.indices){

            Log.e("test",selectedmatchingProducts[i].unitOfMeasure.toString())
        }
    }
}