package com.example.springboot.dao.sadelite;

import com.example.springboot.model.ShareHolder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper
@Component
public interface ShareHolderMapper {

    @Results(id = "holderResultMap", value = {
            @Result(property = "shareHolderId", column = "shareholder_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "email", column = "email")
    })
    @Select("SELECT shareholder_id, first_name, last_name, email " +
            "FROM shareholders " +
            "WHERE shareholder_id = #{shareHolderId}")
    Optional<ShareHolder> findSingleHolderById(@Param("shareHolderId") long shareHolderId);

    @Results(id = "holderResultMapWithOffers", value = {
            @Result(property = "shareHolderId", column = "shareholder_id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "email", column = "email"),
            @Result(property = "offers", column = "shareholder_id",
                    many = @Many(select = "com.example.springboot.dao.sadelite.OfferMapper.selectOffersForHolder"))
    })
    @Select("SELECT shareholder_id, first_name, last_name, email " +
            "FROM shareholders " +
            "WHERE shareholder_id = #{shareHolderId}")
    Optional<ShareHolder> findSingleHolderWithAllOffersById(@Param("shareHolderId") long shareHolderId);


    // USED BY ANOTHER MAPPER

    @ResultMap("holderResultMap")
    @Select("SELECT shareholder_id, first_name, last_name, email " +
            "FROM shareholders " +
            "WHERE shareholder_id = #{shareHolderId}")
    ShareHolder findHolderForOffer(@Param("shareHolderId") long shareHolderId);

}
