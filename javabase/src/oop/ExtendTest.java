package oop;

import java.util.Arrays;
import java.util.List;

public class ExtendTest {
    public static void main(String[] args) {
        List<Snow> snow1 = Arrays.asList(new Crusty(),new Powder(),new Slush());
        List<Snow> snow2 = Arrays.asList(new Light(),new Heavy());
        System.out.println(Arrays.toString(snow1.toArray()));
        System.out.println(Arrays.toString(snow2.toArray()));
    }
}

class Snow {
}

class Powder extends Snow {
}

class Light extends Powder {
}

class Heavy extends Powder {
}

class Crusty extends Snow {
}

class Slush extends Snow {
}

