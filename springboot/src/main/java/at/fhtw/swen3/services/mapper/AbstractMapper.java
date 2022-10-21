package at.fhtw.swen3.services.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractMapper<EN, DTO, DAL> implements BaseMapper<EN, DTO, DAL> {
    public List<DTO> entityToDto(Collection<EN> sources) {
        List<DTO> targets = new ArrayList<>();
        for (EN s : sources) {
            targets.add(entityToDto(s));
        }
        return targets;
    }

    public List<EN> dtoToEntity(Collection<DTO> targets) {
        List<EN> sources = new ArrayList<>();
        for (DTO t : targets) {
            sources.add(dtoToEntity(t));
        }
        return sources;
    }


    public List<DAL> entityToDal(Collection<EN> sources) {
        List<DAL> targets = new ArrayList<>();
        for (EN s : sources) {
            targets.add(entityToDal(s));
        }
        return targets;
    }
}
