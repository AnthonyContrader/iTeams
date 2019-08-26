package it.contrader.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Questa classe implementa i metodi che convertono le liste.
 *
 * @author Vittorio Valent & Girolamo Murdaca
 *
 * @param <Entity>
 * @param <DTO>
 * 
 * @see Converter
 */
public abstract class AbstractConverter<Entity,DTO> implements Converter<Entity,DTO> {

	public List<Entity> toEntityList (Iterable<DTO> listDTO) {
		List<Entity> list = new ArrayList<Entity>();

		if(listDTO != null) {
			for (DTO dto:listDTO) {
				Entity entity = toEntityS(dto);
				list.add(entity);
			}
		}
		return list;
	}
	
	public List<DTO> toDTOList (Iterable<Entity> listEntity) {
		List<DTO> list = new ArrayList<DTO>();

		if(listEntity != null) {
			for (Entity entity:listEntity) {
				DTO dto = toDTOS(entity);
				list.add(dto);
			}
		}
		return list;
	}
	
	public Set<Entity> toEntitySet (Set<DTO> listDTO) {
		Set<Entity> set = new HashSet<Entity>();

		if(listDTO != null) {
			for (DTO dto:listDTO) {
				Entity entity = toEntityS(dto);
				set.add(entity);
			}
		}
		return set;
	}
	
	public Set<DTO> toDTOSet (Set<Entity> listEntity) {
		Set<DTO> set = new HashSet<DTO>();

		if(listEntity != null) {
			for (Entity entity:listEntity) {
				DTO dto = toDTOS(entity);
				set.add(dto);
			}
		}
		return set;
	}
	
}
