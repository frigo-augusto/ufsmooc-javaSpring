package com.ufsmooc.ufsmooc.domain.entities.partition;


import com.ufsmooc.ufsmooc.domain.dto.partition.VideoDto;
import com.ufsmooc.ufsmooc.domain.entities.ModulePartition;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Video{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Video(VideoDto dto){

    }


}
