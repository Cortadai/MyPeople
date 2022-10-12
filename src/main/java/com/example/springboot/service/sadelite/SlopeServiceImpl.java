package com.example.springboot.service.sadelite;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.sadelite.SlopeMapper;
import com.example.springboot.dto.slope.SlopeDto;
import com.example.springboot.model.Slope;

@Service
public class SlopeServiceImpl implements SlopeService {

	 
	private SlopeMapper slopeMapper;
	private ModelMapper modelMapper;

	
	@Autowired
	public SlopeServiceImpl(SlopeMapper slopeMapper, ModelMapper modelMapper) {
		this.slopeMapper = slopeMapper;
		this.modelMapper = modelMapper;
	}

	@Override
	public SlopeDto buscarUno(int id) {
		Slope miSlope = slopeMapper.findSingleSlopeById(id).get();
		return mapToDto(miSlope);
	}

	private SlopeDto mapToDto(Slope slope) {
		return modelMapper.map(slope, SlopeDto.class);
	}
	
	private Slope maptoEntity(SlopeDto dto) {
		return modelMapper.map(dto, Slope.class);
	}

	@Override
	public List<SlopeDto> buscarTodosSlope() {
		List<Slope> miSlope = slopeMapper.findAllSlope();
		List<SlopeDto> listaDto = new ArrayList<>();
		for(Slope SlopeActual : miSlope) {
			listaDto.add(mapToDto(SlopeActual));
		}
		return listaDto;
	}

	@Override
	public String insertSlope(SlopeDto slopeDto) {
		// convertir el Dto que llega en entidad
		Slope slope = maptoEntity(slopeDto);
		//ejecutar la sentencia
		int resultado = slopeMapper.insertSlope(slope);
		//developer resultado
		if (resultado != 0) {
			return "¡¡ El Sloper se ha creado con Exito en el Sistema !!";
		}else {
			return "¡¡ Algo ha pasado y el Sloper NO ha sido creado !!";
		}
	}

	@Override
	public String updateSloperOrigin(SlopeDto slopeDto) {
		// convertir el Dto que llega en entidad
		Slope slope = maptoEntity(slopeDto);
		//ejecutar la sentencia
		int resultado = slopeMapper.updateSloperOrigin(slope);
		//developer resultado
		if (resultado != 0) {
			return "¡¡ El Origin del Sloper se ha modificado con Exito en el Sistema !!";
		}else {
			return "¡¡ Algo ha pasado y el Origin del Sloper NO ha sido modificado !!";
		}
	}

	@Override
	public String deleteSlope(SlopeDto slopeDto) {
		// convertir el Dto que llega en entidad
		Slope slope = maptoEntity(slopeDto);
		//ejecutar la sentencia
		int resultado = slopeMapper.updateSloperOrigin(slope);
		//devolver un String con el resultado positivo
		if (resultado != 0) {
			return "¡¡ El Slope Ha sido Eliminado del Sistema !!";
		}else {
			return "¡¡ Algo ha pasado y el Origin del Sloper NO ha sido modificado !!";
		}
	}
}
