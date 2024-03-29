package fr.wowcompanion.server.model.mother;

import lombok.Data;

import fr.jbwittner.blizzardswagger.wowretailapi.model.NameData;
import fr.wowcompanion.server.model.embeddable.LocalizedModel;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract class for Blizzard models
 */
@Data
@MappedSuperclass
public class MotherLocalizedBlizzardModel {

    @Id
    @Column(name = "ID", nullable = false, updatable = false, insertable = false, unique = true)
    protected Integer id;

    @Embedded
    private LocalizedModel localizedModel;

    public void buildLocalizedModel(final NameData nameData){
        this.localizedModel = new LocalizedModel();
        this.localizedModel.updateLocalizedValue(nameData);
    }

}