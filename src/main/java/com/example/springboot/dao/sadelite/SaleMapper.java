package com.example.springboot.dao.sadelite;

import com.example.springboot.model.Sale;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Mapper
@Component
public interface SaleMapper {

    @Results(id = "saleResultMap", value = {
            @Result(property = "saleId", column = "sale_id"),
            @Result(property = "minPrice", column = "min_price"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "publicationDate", column = "publication_date"),
            @Result(property = "expirationDate", column = "expiration_date"),
            @Result(property = "status", column = "status")
    })
    @Select("SELECT sale_id, min_price, quantity, publication_date, expiration_date, `status` " +
            "FROM sales " +
            "WHERE sale_id=#{saleId}")
    Optional<Sale> findSingleSaleById(@Param("saleId") long saleId);

    @Results(id = "saleResultMapWithStock", value = {
            @Result(property = "saleId", column = "sale_id"),
            @Result(property = "minPrice", column = "min_price"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "publicationDate", column = "publication_date"),
            @Result(property = "expirationDate", column = "expiration_date"),
            @Result(property = "status", column = "status"),
            @Result(property = "stockShare", column = "stockshare_id",
                    one = @One(select = "com.example.springboot.dao.sadelite.StockShareMapper.findStockShareForSale"))
    })
    @Select("SELECT sale_id, min_price, quantity, publication_date, expiration_date, `status`, stockshare_id " +
            "FROM sales")
    List<Sale> findAllSalesWithStock();

    @ResultMap("saleResultMapWithStock")
    @Select("SELECT sale_id, min_price, quantity, publication_date, expiration_date, `status`, stockshare_id " +
            "FROM sales " +
            "WHERE sale_id = #{saleId}")
    Optional<Sale> findSingleSaleWithStockById(@Param("saleId") long saleId);

    @ResultMap("saleResultMapWithStock")
    @Select("SELECT sale_id, min_price, quantity, publication_date, expiration_date, `status`, stockshare_id " +
            "FROM sales " +
            "WHERE `status` LIKE 'ACTIVE' " +
            "AND stockshare_id=#{stockShareId}")
    List<Sale> findAllActiveSalesWithStockByStockId(@Param("stockShareId") long stockShareId);

    @Results({
            @Result(property = "saleId", column = "sale_id"),
            @Result(property = "minPrice", column = "min_price"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "publicationDate", column = "publication_date"),
            @Result(property = "expirationDate", column = "expiration_date"),
            @Result(property = "status", column = "status"),
            @Result(property = "offers", column = "sale_id",
                    many = @Many(select = "com.example.springboot.dao.sadelite.OfferMapper.selectOffersForSale")),
            @Result(property = "stockShare", column = "stockshare_id",
                    one = @One(select = "com.example.springboot.dao.sadelite.StockShareMapper.findStockShareForSale"))
    })
    @Select("SELECT sale_id, min_price, quantity, publication_date, expiration_date, `status`, stockshare_id " +
            "FROM sales " +
            "WHERE `status` NOT LIKE 'ARCHIVED'")
    List<Sale> findAllNonArchivedSalesWithOffersWithStock();

    @Results(id = "saleResultMapWithOffers", value = {
            @Result(property = "saleId", column = "sale_id"),
            @Result(property = "minPrice", column = "min_price"),
            @Result(property = "quantity", column = "quantity"),
            @Result(property = "publicationDate", column = "publication_date"),
            @Result(property = "expirationDate", column = "expiration_date"),
            @Result(property = "status", column = "status"),
            @Result(property = "offers", column = "sale_id",
                    many = @Many(select = "com.example.springboot.dao.sadelite.OfferMapper.selectOffersForSale"))
    })
    @Select("SELECT sale_id, min_price, quantity, publication_date, expiration_date, `status` " +
            "FROM sales " +
            "WHERE sale_id = #{saleId}")
    Optional<Sale> findSingleSaleWithOffersById(@Param("saleId") long saleId);

    @Update("UPDATE sales " +
            "SET `status`=#{status} " +
            "WHERE sale_id=#{saleId}")
    int updateSaleStatus(Sale sale);


    // USED BY ANOTHER MAPPER

    @ResultMap("saleResultMap")
    @Select("select sale_id, min_price, quantity, publication_date, expiration_date, `status` from sales where sale_id = #{saleId}")
    Sale findSaleForOffer(@Param("saleId") long saleId);

    @ResultMap("saleResultMapWithStock")
    @Select("select sale_id, min_price, quantity, publication_date, expiration_date, `status`, stockshare_id from sales where sale_id = #{saleId}")
    Sale findSaleWithStockForOffer(@Param("saleId") long saleId);

}
