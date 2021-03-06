package me.xdrop.jrand.generators.basics

import me.xdrop.jrand.JRand

class DecimalGeneratorTest extends GroovyTestCase {
    def instance = { -> JRand.decimal() }

    void testMin() {
        assertTrue instance().min(5.0 as double).genAsDecimal() >= 5
    }

    void testMax() {
        assertTrue instance().max(5.0 as double).genAsDecimal() <= 5
    }

    void testRange() {
        def res = instance().range(0.0 as double, 1.0 as double).genAsDecimal()
        def res2 = instance().range(0.0 as double, 3.0 as double).genAsDecimal()
        assertTrue res >= 0.0 && res <= 1.0
        assertTrue res2 >= 0.0 && res <= 3.0

    }

    void testDigits() {
        def gen = instance().digits(2).gen().split("\\.")[1]
        assertTrue gen.length() == 2
    }

    void testRoundUp() {
        // TODO: Implement
    }
}
