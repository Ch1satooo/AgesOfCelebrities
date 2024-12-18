// this class is used to convert celebrity to celebrityDTO
package com.Ch1satooo.AgeOfCelebrities.converter;

import com.Ch1satooo.AgeOfCelebrities.dto.CelebrityDTO;
import com.Ch1satooo.AgeOfCelebrities.model.Celebrity;

public class CelebrityConverter {

    // Utility methods always use `static`
    public static CelebrityDTO convertCelebrity(Celebrity celebrity) {
        CelebrityDTO celebrityDTO = new CelebrityDTO();
        celebrityDTO.setId(celebrity.getId());
        celebrityDTO.setName(celebrity.getName());
        celebrityDTO.setBirthDate(celebrity.getBirthDate());
        celebrityDTO.setGender(celebrity.getGender());
        celebrityDTO.setProfession(celebrity.getProfession());
        celebrityDTO.setNationality(celebrity.getNationality());
        return celebrityDTO;
    }

    public static Celebrity convertCelebrityDTO(CelebrityDTO celebrityDTO) {
        Celebrity celebrity = new Celebrity();
        celebrity.setName(celebrityDTO.getName());
        celebrity.setBirthDate(celebrityDTO.getBirthDate());
        celebrity.setGender(celebrityDTO.getGender());
        celebrity.setProfession(celebrityDTO.getProfession());
        celebrity.setNationality(celebrityDTO.getNationality());
        return celebrity;
    }

}
