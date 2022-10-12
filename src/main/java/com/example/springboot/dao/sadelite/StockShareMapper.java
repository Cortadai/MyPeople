package com.example.springboot.dao.sadelite;

import com.example.springboot.model.StockShare;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Mapper
@Component
public interface StockShareMapper {

    @Results(id = "stockResultMap", value = {
            @Result(property = "stockShareId", column = "stockshare_id"),
            @Result(property = "numTotal", column = "num_total"),
            @Result(property = "stockType", column = "stock_type")
    })
    @Select("SELECT stockshare_id, num_total, stock_type " +
            "FROM stockshares " +
            "WHERE stockshare_id = #{stockShareId}")
    Optional<StockShare> findSingleStockShareById(@Param("stockShareId") long stockShareId);

    @ResultMap("stockResultMap")
    @Select("SELECT stockshare_id, num_total, stock_type " +
            "FROM stockshares " +
            "WHERE shareholder_id = #{shareHolderId}")
    List<StockShare> findAllStockSharesByHolderId(@Param("shareHolderId") long shareHolderId);

    @Update("UPDATE stockshares " +
            "SET num_total=#{numTotal} " +
            "WHERE stockshare_id=#{stockShareId}")
    int updateStockShareNumTotal(StockShare stockShare);

    @Insert("INSERT INTO stockshares(num_total, stock_type, shareholder_id) " +
            "VALUES (#{numTotal}, #{stockType}, #{shareHolder.shareHolderId})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "stockShareId",
            before = false, resultType = long.class)
    int insertStockShare(StockShare stockShare);


    // USED BY ANOTHER MAPPER

    @ResultMap("stockResultMap")
    @Select("SELECT stockshare_id, num_total, stock_type " +
            "FROM stockshares " +
            "WHERE stockshare_id = #{stockShareId}")
    StockShare findStockShareForSale(@Param("stockShareId") long stockShareId);

}
