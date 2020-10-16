package com.example.shopping.sliderImages;

import com.example.shopping.common.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "SLIDER_IMAGES")

public class SliderImages extends BaseEntity {

    private String fileName;

    private String fileType;

    @Lob
    private byte[] data;

    public SliderImages(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

}