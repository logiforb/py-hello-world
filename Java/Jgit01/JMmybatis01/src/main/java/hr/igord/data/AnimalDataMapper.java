package hr.igord.data;

import java.util.List;

public interface AnimalDataMapper {

    AnimalData selectAnimalData(int id);
    
    List<AnimalData> selectAllAnimalData();
}
