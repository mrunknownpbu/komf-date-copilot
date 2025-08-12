// This is the entry point of the userscript. It initializes the script, sets up event listeners, and integrates the functionalities provided by the services and utilities.

import { KomfDateCopilot } from './services/komfDateCopilot';
import { setupDOMListeners } from './utils/dom';

const init = () => {
    const dateCopilot = new KomfDateCopilot();
    
    // Initialize the date functionalities
    dateCopilot.initialize();

    // Set up DOM event listeners
    setupDOMListeners();
};

// Run the initialization function when the script is loaded
init();