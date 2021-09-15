
echo "# Lines of Codes" > LinesOfCode.md

echo "## Framework" >> LinesOfCode.md

echo "### HTML" >> LinesOfCode.md
cloc Framework.languages/HTML/lang/src --md | grep -E "^(Language|:|Java|Xtend)" >> LinesOfCode.md

echo "### RobLANG" >> LinesOfCode.md
cloc Framework.languages/RobLANG/lang/src --md | grep -E "^(Language|:|Java|Xtend)" >> LinesOfCode.md

echo "### MiniJava" >> LinesOfCode.md
cloc Framework.languages/MiniJava/lang/src --md | grep -E "^(Language|:|Java|Xtend)" >> LinesOfCode.md


echo "## Handcraft" >> LinesOfCode.md

echo "### HTML (Two projects)" >> LinesOfCode.md
cloc Handcraft.languages/HTML/HTML-AdaptivePrettyPrinter/HTMLPrettyPrinter/src --md | grep -E "^(Language|:|Java|Xtend)" >> LinesOfCode.md
cloc Handcraft.languages/HTML/Truffle-Adaptable-Language/src --md | grep -E "^(Java|Xtend)" >> LinesOfCode.md

echo "### RobLANG" >> LinesOfCode.md
cloc Handcraft.languages/RobLANG/fr.gwendal_jouneaux.rob_lang/src --md | grep -E "^(Language|:|Java|Xtend)" >> LinesOfCode.md

echo "### MiniJava" >> LinesOfCode.md
cloc Handcraft.languages/MiniJava/selfadaptable-minijava.lang.interpreter/interpreter-comp --md | grep -E "^(Language|:|Java|Xtend)" >> LinesOfCode.md
