package pl.whattoeat.whattoeat_spring.model;

public class Selectors {

    public enum SortingSelector {
        DONT_SORT,
        SORT_BY_INGREDIENT_COUNT,
        SORT_BY_MATCH_PERCENTAGE
    }

    public static SortingSelector sortingSelector = SortingSelector.DONT_SORT;
}

