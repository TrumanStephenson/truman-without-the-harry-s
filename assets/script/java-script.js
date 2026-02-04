// Initialize CheerpJ runtime
cheerpjInit();

// Load your compiled JAR file (replace with your actual path)
cheerpjRunMain('/java/app.jar').then(() => {
    appendOutput('Java classes loaded. Type help for commands.');
});

const terminal = document.getElementById('terminal');
const input = document.getElementById('input');

// List of available commands mapped to Java class main methods
const commands = {
    treelist: 'TreeList',
    treelisttest: 'TreeListTest',
    trees: 'Trees',
    quarts: 'QuartsToGallonsInteractiveException',
    geometry: 'MethodsFor6GeometryForumlas',
    fivedice: 'FiveDice',
    fivedicethrow: 'FiveDiceThrow'
};

function appendOutput(text) {
    terminal.textContent += text + '\n\n';
    terminal.scrollTop = terminal.scrollHeight;
}

async function runCommand(cmd) {
    if (cmd === 'help') {
    appendOutput('Available commands: ' + Object.keys(commands).join(', '));
    appendOutput('Type a command to run its Java class main method.');
    } else if (cmd === 'clear') {
    terminal.textContent = '';
    } else if (commands[cmd]) {
    appendOutput('Running ' + cmd + '...');
    try {
        await cheerpjRunMain(commands[cmd], []);
        appendOutput('Finished running ' + cmd + '.');
    } catch (e) {
        appendOutput('Error running ' + cmd + ': ' + e);
    }
    } else {
    appendOutput('Unknown command: ' + cmd);
    }
}

input.addEventListener('keydown', async (e) => {
    if (e.key === 'Enter') {
    const cmd = input.value.trim().toLowerCase();
    if (cmd) {
        appendOutput('> ' + cmd);
        await runCommand(cmd);
        input.value = '';
    }
    }
});
