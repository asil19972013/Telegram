package uz.pdp.telegram.backend.model;

import uz.pdp.telegram.backend.BaceModel;
import uz.pdp.telegram.backend.enums.MassageType;

public class Massage extends BaceModel {

    private MassageType type;

    private String from;

    private String to;
}
