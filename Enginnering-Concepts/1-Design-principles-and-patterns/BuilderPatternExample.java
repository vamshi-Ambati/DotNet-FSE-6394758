public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer gamingPC = new Computer.Builder("Intel i9", "32GB")
                .storage("2TB SSD")
                .graphicsCard("NVIDIA RTX 4090")
                .powerSupply("850W")
                .build();
        System.out.println(gamingPC);

        Computer officePC = new Computer.Builder("Intel i5", "8GB")
                .build();
        System.out.println(officePC);

        Computer customPC = new Computer.Builder("AMD Ryzen 7", "16GB")
                .storage("1TB HDD")
                .graphicsCard("AMD Radeon RX 6700")
                .build();
        System.out.println(customPC);
    }
}

class Computer {
    private final String cpu;
    private final String ram;

    private final String storage;
    private final String graphicsCard;
    private final String powerSupply;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.powerSupply = builder.powerSupply;
    }

    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private final String cpu;
        private final String ram;

        // Optional parameters - initialized to default values
        private String storage = "512GB SSD";
        private String graphicsCard = "Integrated";
        private String powerSupply = "500W";

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder powerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram +
                ", Storage=" + storage +
                ", Graphics Card=" + graphicsCard +
                ", Power Supply=" + powerSupply + "]";
    }
}
