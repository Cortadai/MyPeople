package com.example.springboot.dao.sadelite;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.example.springboot.model.Offer;

@Mapper
@Component
public interface OfferMapper {

    @Results(id = "offerResultMap", value = {
            @Result(property = "offerId", column = "offer_id"),
            @Result(property = "price", column = "price"),
            @Result(property = "initialDate", column = "initial_date"),
            @Result(property = "finalDate", column = "final_date"),
            @Result(property = "status", column = "status")
    })
    @Select("SELECT offer_id, price, initial_date, final_date, `status` " +
            "FROM offers " +
            "WHERE offer_id=#{offerId}")
    Optional<Offer> findSingleOfferById(@Param("offerId") long offerId);

    @ResultMap("offerResultMapWithSaleWithHolder")
    @Select("SELECT offer_id, price, initial_date, final_date, `status`, sale_id, shareholder_id " +
            "FROM offers " +
            "WHERE `status` NOT LIKE 'ARCHIVED'")
    List<Offer> findAllNonArchivedOffersWithSale();

    @Results(id = "offerResultMapWithSale", value = {
            @Result(property = "offerId", column = "offer_id"),
            @Result(property = "price", column = "price"),
            @Result(property = "initialDate", column = "initial_date"),
            @Result(property = "finalDate", column = "final_date"),
            @Result(property = "status", column = "status"),
            @Result(property = "sale", column = "sale_id",
                    one = @One(select = "com.example.springboot.dao.sadelite.SaleMapper.findSaleForOffer"))
    })
    @Select("SELECT offer_id, price, initial_date, final_date, `status`, sale_id " +
            "FROM offers " +
            "WHERE offer_id=#{offerId}")
    Optional<Offer> findSingleOfferWithSaleById(@Param("offerId") long offerId);

    @ResultMap("offerResultMapWithSale")
    @Select("select offer_id, price, initial_date, final_date, `status`, sale_id " +
            "FROM offers")
    List<Offer> findAllOffersWithSale();

    @Results(id = "offerResultMapWithSaleAndStock", value = {
            @Result(property = "offerId", column = "offer_id"),
            @Result(property = "price", column = "price"),
            @Result(property = "initialDate", column = "initial_date"),
            @Result(property = "finalDate", column = "final_date"),
            @Result(property = "status", column = "status"),
            @Result(property = "sale", column = "sale_id",
                    one = @One(select = "com.example.springboot.dao.sadelite.SaleMapper.findSaleWithStockForOffer"))
    })
    @Select("SELECT offer_id, price, initial_date, final_date, `status`, sale_id " +
            "FROM offers")
    List<Offer> findAllOffersWithSaleAndStock();

    @Results(id = "offerResultMapWithHolder", value = {
            @Result(property = "offerId", column = "offer_id"),
            @Result(property = "price", column = "price"),
            @Result(property = "initialDate", column = "initial_date"),
            @Result(property = "finalDate", column = "final_date"),
            @Result(property = "status", column = "status"),
            @Result(property = "shareHolder", column = "shareholder_id",
                    one = @One(select = "com.example.springboot.dao.sadelite.ShareHolderMapper.findHolderForOffer"))
    })
    @Select("SELECT offer_id, price, initial_date, final_date, `status`, shareholder_id " +
            "FROM offers")
    List<Offer> findAllOffersWithHolder();

    @Results(id = "offerResultMapWithSaleWithHolder", value = {
            @Result(property = "offerId", column = "offer_id"),
            @Result(property = "price", column = "price"),
            @Result(property = "initialDate", column = "initial_date"),
            @Result(property = "finalDate", column = "final_date"),
            @Result(property = "status", column = "status"),
            @Result(property = "sale", column = "sale_id",
                    one = @One(select = "com.example.springboot.dao.sadelite.SaleMapper.findSaleWithStockForOffer")),
            @Result(property = "shareHolder", column = "shareholder_id",
                    one = @One(select = "com.example.springboot.dao.sadelite.ShareHolderMapper.findHolderForOffer"))
    })
    @Select("SELECT offer_id, price, initial_date, final_date, `status`, sale_id, shareholder_id " +
            "FROM offers " +
            "WHERE offer_id=#{offerId}")
    Optional<Offer> findSingleOfferWithSaleWithHolderById(@Param("offerId") long offerId);

    @ResultMap("offerResultMapWithHolder")
    @Select("SELECT offer_id, price, initial_date, final_date, `status`, shareholder_id " +
            "FROM offers " +
            "WHERE `status` LIKE 'ACTIVE' " +
            "AND sale_id = #{saleId}")
    List<Offer> findAllActiveOffersWithHolderBySaleId(@Param("saleId") long saleId);

    @Update("UPDATE offers " +
            "SET `status`=#{status}, final_date=#{finalDate} " +
            "WHERE offer_id=#{offerId}")
    int updateOfferStatus(Offer offer);

    @Insert("INSERT INTO offers(price, initial_date, `status`, sale_id, shareholder_id) " +
            "VALUES (#{price}, #{initialDate}, #{status}, #{sale.saleId}, #{shareHolder.shareHolderId})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "offerId",
            before = false, resultType = long.class)
    int insertOffer(Offer offer);


    // USED BY ANOTHER MAPPER

    @ResultMap("offerResultMap")
    @Select("SELECT offer_id, price, initial_date, final_date, `status` " +
            "FROM offers WHERE shareholder_id=#{shareHolderId}")
    List<Offer> selectOffersForHolder(@Param("shareHolderId") long shareHolderId);

    @ResultMap("offerResultMap")
    @Select("SELECT offer_id, price, initial_date, final_date, `status` " +
            "FROM offers WHERE sale_id=#{saleId}")
    List<Offer> selectOffersForSale(@Param("saleId") long saleId);

}
