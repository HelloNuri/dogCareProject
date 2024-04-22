function deleteSupply(e){
    console.log("deleteSupply()");
    return false;
}

function insertSupply(e){
    let parent = document.querySelectorAll('div.items:last-of-type')[2];
    const template = getSupplyTemplate();
    //template 만들기
    parent.insertBefore(template, parent.lastElementChild);
}

function getSupplyTemplate(){
    const itemDiv = document.createElement('div'); // Create the main 'item' div
    itemDiv.classList.add('item'); // Add the 'item' class
    
    const selectElement = document.createElement('select'); // Create the select element
    selectElement.classList.add('form-select'); // Add the 'form-select' class
    
    const defaultOption = document.createElement('option'); // Create the default option
    defaultOption.textContent = '종류';
    selectElement.appendChild(defaultOption); // Add the default option to the select
    
    const productOptions = getSupplyOptions();
    
    for (const productOption of productOptions) {
      const optionElement = document.createElement('option');
      optionElement.value = productOption.value;
      optionElement.textContent = productOption.text;
      selectElement.appendChild(optionElement);
    }
    
    itemDiv.appendChild(selectElement); // Add the select element to its div
    
    const inputGroupDiv = document.createElement('div'); // Create a div for the input group
    inputGroupDiv.classList.add('input-group'); // Add the 'input-group' class
    
    const inputElement = document.createElement('input'); // Create the input element
    inputElement.type = 'text';
    inputElement.classList.add('form-control');
    inputElement.placeholder = ' ';
    inputElement.required = true;
    inputGroupDiv.appendChild(inputElement); // Add the input element to its div
    
    const spanElement = document.createElement('span'); // Create the span for the icon
    spanElement.classList.add('input-group-text'); // Add the 'input-group-text' class
    
    const svgElement = document.createElementNS('http://www.w3.org/2000/svg', 'svg'); // Create the SVG element
    svgElement.setAttribute('width', '25');
    svgElement.setAttribute('height', '25');
    svgElement.setAttribute('fill', 'currentColor');
    svgElement.classList.add('bi', 'bi-dash-square-fill');
    svgElement.setAttribute('viewBox', '0 0 16 16');
    
    const pathElement = document.createElementNS('http://www.w3.org/2000/svg', 'path'); // Create the SVG path
    pathElement.setAttribute('d', 'M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zm2.5 7.5h7a.5.5 0 0 1 0 1h-7a.5.5 0 0 1 0-1');
    
    svgElement.appendChild(pathElement); // Add the path to the SVG
    spanElement.appendChild(svgElement); // Add the SVG to the span
    inputGroupDiv.appendChild(spanElement); // Add the span to the input group div
    itemDiv.appendChild(inputGroupDiv); // Add the input group div to the main 'item' div
    
    return itemDiv;

}

function getSupplyOptions(){
    let options = [
        { value: '사료', text: '사료' },
        { value: '치약', text: '치약' },
        { value: '목줄', text: '목줄' },
        { value: '장난감', text: '장난감' },
      ];
    return options;
}

function submitDogInfo(e){
    console.log("submitDogInfo()");
    e.preventDefault();
    // hidden type input도 채워야 함.
}

function fillDogs(){
    console.log("fillDogs");
    return false;
}

function updateSelectedDog(dogId){
    console.log("updateSelectedDog: " + dogId);
    return false;
}