package com.stay.hub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.stay.hub.enums.residence.GenderPreferenceType;
import com.stay.hub.enums.residence.OccupancyType;
import com.stay.hub.enums.residence.ResidenceType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
public class ResidenceData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private ResidenceType residenceType;

    @Enumerated(EnumType.STRING)
    private GenderPreferenceType genderPreferenceType;

    private Long startingRent;
    private Long StartingDeposit;

    private boolean available;

    private Integer rating;

    @ElementCollection
    @CollectionTable(name = "residence_rent", joinColumns = @JoinColumn(name = "residence_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "occupancy_type")
    @Column(name = "rent")
    private Map<OccupancyType, Long> rentByOccupancy = new HashMap<>();

    @CreationTimestamp
    private LocalDateTime createDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    @JsonBackReference
    private UserData owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private LocationData location;

    @OneToMany(mappedBy = "residence", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ReviewData> reviews = new ArrayList<>();

}
