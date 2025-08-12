export function selectElement(selector: string): HTMLElement | null {
    return document.querySelector(selector);
}

export function selectAllElements(selector: string): NodeListOf<HTMLElement> {
    return document.querySelectorAll(selector);
}

export function createElement(tag: string, className?: string, textContent?: string): HTMLElement {
    const element = document.createElement(tag);
    if (className) {
        element.className = className;
    }
    if (textContent) {
        element.textContent = textContent;
    }
    return element;
}

export function appendChild(parent: HTMLElement, child: HTMLElement): void {
    parent.appendChild(child);
}

export function removeElement(element: HTMLElement): void {
    if (element.parentNode) {
        element.parentNode.removeChild(element);
    }
}

export function setElementText(element: HTMLElement, text: string): void {
    element.textContent = text;
}

export function addEventListenerToElement(element: HTMLElement, event: string, handler: EventListener): void {
    element.addEventListener(event, handler);
}