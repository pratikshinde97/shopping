package com.example.shopping.Item;

import com.example.shopping.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UploadImage")

public class UploadImage extends BaseEntity {

    @Lob
    @Column(name = "photo", columnDefinition="BLOB")
    private byte[] data;

}
