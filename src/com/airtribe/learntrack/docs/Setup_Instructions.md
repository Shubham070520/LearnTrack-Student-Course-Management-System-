# Setup Instructions – LearnTrack Project

## JDK Version Used
- Java Version: **23.0.2**
- Vendor: Oracle
- Runtime: Java(TM) SE Runtime Environment
- JVM: Java HotSpot(TM) 64-Bit Server VM

Verified using the command:
```bash
java -version
```

```yaml
hello_world:
  description: Basic Java program execution to verify setup
  code: |
    public class Main {
        public static void main(String[] args) {
            System.out.println("Hello, World!");
        }
    }
  steps_to_run:
    - compile: javac Main.java
    - run: java Main
  output: |
    Hello, World!
```




