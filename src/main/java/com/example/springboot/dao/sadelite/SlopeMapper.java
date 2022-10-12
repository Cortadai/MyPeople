package com.example.springboot.dao.sadelite;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import com.example.springboot.model.Slope;

@Mapper
@Component
public interface SlopeMapper {
	
	//SELECT DE UN SOLO REGISTRO
    @Results(id = "slopeResultMap", value = {
            @Result(property = "codSlope", column = "COD_SLOPE"),
            @Result(property = "minValue", column = "MIN_SLOPE"),
            @Result(property = "maxValue", column = "MAX_SLOPE"),
            @Result(property = "origin", column = "ORIGIN")
    })
    @Select("SELECT COD_SLOPE, MIN_SLOPE, MAX_SLOPE, ORIGIN " +
            "FROM SLOPE " +
            "WHERE COD_SLOPE=#{codSlope}")
    Optional<Slope> findSingleSlopeById(@Param("codSlope") int codSlope);
    
    //SELECT DE TODOS LOS REGISTROS
    @ResultMap("slopeResultMap") //reutilizo el id de @Results ya creado antes OJO @ResultMap
    @Select("SELECT COD_SLOPE, MIN_SLOPE, MAX_SLOPE, ORIGIN FROM SLOPE")
    List<Slope> findAllSlope();
    
    //INSERTAR 
    @Insert("INSERT INTO SLOPE(MIN_SLOPE, MAX_SLOPE, ORIGIN) VALUES(#{minValue},#{maxValue},#{origin})")
    //CON SELECTKEY NOS GUARDAMOS LA ID DESPUES DE INSERTAR
    @SelectKey(statement = "select last_instert_id()", keyProperty = "codSlope", before = false, resultType = int.class)
    int insertSlope(Slope slope);
    
    //MODIFICAR EL CAMPO ORIGEN DESDE 
    @Update("UPDATE SET ORIGIN = #{origin} WHERE COD_SLOPE = #{codSlope}")
    int updateSloperOrigin(Slope slope);
    
    
    //ELIMINAR UN REGISTRO
    @Delete("DELETE FROM SLOPE WHERE COD_SLOPE = #{codSlope}")
    int deleteSlope(Slope slope);

}
