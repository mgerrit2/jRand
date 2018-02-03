package me.xdrop.jrand.generators.location;

import me.xdrop.jrand.Generator;
import me.xdrop.jrand.annotation.Facade;
import me.xdrop.jrand.generators.basics.DecimalGenerator;
import me.xdrop.jrand.model.RangeOption;

@Facade(accessor = "longitude")
public class LongitudeGenerator extends Generator<String> {
    private RangeOption<Double> range;
    private int decimals;
    private DecimalGenerator decimal;

    public LongitudeGenerator() {
        this.decimals = 5;
        this.decimal = new DecimalGenerator();
        this.decimal.range(RangeOption.from(-180.0, 180.0));
    }

    /**
     * Set the number of decimals to return
     * @param noOfDecimals The number of decimals to return
     * @return The same generator
     */
    public LongitudeGenerator decimals(int noOfDecimals) {
        this.decimal.digits(noOfDecimals);
        return this;
    }

    /**
     * Set the minimum, and maximum longitude
     * @param min Minimum latitude (inclusive)
     * @param max Maximum latitude (inclusive)
     * @return The same generator
     */
    public LongitudeGenerator range(double min, double max) {
        this.decimal.range(min, max);
        return this;
    }

    @Override
    public String gen() {
        return decimal.gen();
    }
}
