(async () => {
    await cheerpjInit();
    await cheerpjRunJar("../assets/app/app.jar");
    appendOutput("Java classes loaded. Type 'help' for commands.");
})();

const terminal = document.getElementById("terminal");
const input = document.getElementById("terminal-input");

const commands = {
    treelist: "TreeList",
    treelisttest: "TreeListTest",
    trees: "Trees",
    quarts: "QuartsToGallonsInteractiveException",
    geometry: "MethodsFor6GeometryForumlas",
    fivedice: "FiveDice",
    fivedicethrow: "FiveDiceThrow"
};

function appendOutput(text) {
    terminal.textContent += text + "\n\n";
    terminal.scrollTop = terminal.scrollHeight;
}

async function runCommand(cmd) {
    if (cmd === "help") {
        appendOutput("Available commands: " + Object.keys(commands).join(", "));
        return;
    }

    if (cmd === "clear") {
        terminal.textContent = "";
        return;
    }

    if (commands[cmd]) {
        appendOutput("Running " + cmd + "...");
        try {
            await cheerpjRunMain(commands[cmd], []);
            appendOutput("Finished running " + cmd + ".");
        } catch (err) {
            appendOutput("Error running " + cmd + ": " + err);
        }
        return;
    }

    appendOutput("Unknown command: " + cmd);
}

input.addEventListener("keydown", async (e) => {
    if (e.key === "Enter") {
        const cmd = input.value.trim().toLowerCase();
        if (cmd) {
            appendOutput("> " + cmd);
            await runCommand(cmd);
            input.value = "";
        }
    }
});