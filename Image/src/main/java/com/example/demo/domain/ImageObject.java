package com.example.demo.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class ImageObject {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private int count;

    private int price;

    @Column(name = "FILENAME")
    private String filename;

    @Column(name = "FILEPATH")
    private String filepath;

    public ImageObject(
            String title,
            String content,
            int count,
            int price,
            String filename,
            String filepath) {
        this.title = title;
        this.content = content;
        this.count = count;
        this.price = price;

        this.filename = filename;
        this.filepath = filepath;
    }
}
