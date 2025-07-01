package com.Railway.dataObject.Enum;

public enum SeattypeEnum {
    HARD_SEAT("Hard seat"),
    SOFT_SEAT("Soft seat"),
    SOFT_SEAT_AC("Soft seat with air conditioner"),
    HARD_BED("Hard bed"),
    SOFT_BED("Soft bed"),
    SOFT_BED_AC("Soft bed with air conditioner");

    private final String displayName;

    SeattypeEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public static SeattypeEnum fromString(String name) {
        for (SeattypeEnum type : SeattypeEnum.values()) {
            if (type.displayName.equalsIgnoreCase(name.trim())) {
                return type;
            }
        }
        throw new IllegalArgumentException("Không tìm thấy SeattypeEnum: " + name);
    }
}
