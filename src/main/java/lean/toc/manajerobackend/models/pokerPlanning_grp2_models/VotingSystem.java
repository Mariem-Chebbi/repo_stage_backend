package lean.toc.manajerobackend.models.pokerPlanning_grp2_models;

import lombok.Getter;

@Getter
public enum VotingSystem {
    FIBONACCI("Fibonacci (0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ?, ☕️)"),
    MODIFIED_FIBONACCI("Modified Fibonacci (0, ½, 1, 2, 3, 5, 8, 13, 20, 40, 100, ?, ☕)"),
    TSHIRTS("T-shirts (XS, S, M, L, XL, ?, ☕)"),
    POWERS_OF_2("Powers of 2 (0, 1, 2, 4, 8, 16, 32, 64, ?, ☕)");

    private final String description;

    VotingSystem(String description) {
        this.description = description;
    }


}
