# Java compiler
JC = javac

# Java runtime
JAVA = java

# JavaFX modules
MODULES = javafx.controls,javafx.fxml

# JavaFX SDK directory
JAVAFX_DIR = /Users/vladmaslianko/Downloads/javafx-sdk-21.0.2/lib

# Source directory
SRC_DIR = .

# Output directory
OUT_DIR = .

# Java source files
JAVA_FILES = $(wildcard $(SRC_DIR)/*.java)

# Output class files
CLASS_FILES = $(patsubst $(SRC_DIR)/%.java,$(OUT_DIR)/%.class,$(JAVA_FILES))

# Main class
MAIN_CLASS = App.java

# Make all rule
all: $(CLASS_FILES)

# Rule for compiling Java source files
$(OUT_DIR)/%.class: $(SRC_DIR)/%.java
	$(JC) -d $(OUT_DIR) --module-path $(JAVAFX_DIR) --add-modules $(MODULES) $<

# Rule for running the JavaFX program
run: all
	$(JAVA) --module-path $(JAVAFX_DIR) --add-modules $(MODULES) $(MAIN_CLASS)

# Clean rule
clean:
	rm -rf $(OUT_DIR)

# Phony targets
.PHONY: all run clean
