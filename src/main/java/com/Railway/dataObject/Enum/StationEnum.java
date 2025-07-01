package com.Railway.dataObject.Enum;

public enum StationEnum {
    SAI_GON("Sài Gòn"),
    PHAN_THIET("Phan Thiết"),
    QUANG_NGAI("Quang Ngãi"),
    NHA_TRANG("Nha Trang"),
    DA_NANG("Đà Nẵng"),
    HUE("Huế");

    private final String displayName;

    StationEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public static StationEnum fromString(String name) {
        for (StationEnum station : StationEnum.values()) {
            if (station.displayName.equalsIgnoreCase(name.trim())) {
                return station;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy StationEnum: " + name);
    }
}
