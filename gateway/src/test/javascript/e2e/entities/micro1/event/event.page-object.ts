import { element, by, ElementFinder } from 'protractor';

export class EventComponentsPage {
    createButton = element(by.id('jh-create-entity'));
    title = element.all(by.css('jhi-event div h2#page-heading span')).first();

    async clickOnCreateButton() {
        await this.createButton.click();
    }

    async getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class EventUpdatePage {
    pageTitle = element(by.id('jhi-event-heading'));
    saveButton = element(by.id('save-entity'));
    cancelButton = element(by.id('cancel-save'));
    rateInput = element(by.id('field_rate'));
    cityInput = element(by.id('field_city'));
    addressInput = element(by.id('field_address'));
    statusInput = element(by.id('field_status'));
    matchtimeInput = element(by.id('field_matchtime'));
    sportSelect = element(by.id('field_sport'));

    async getPageTitle() {
        return this.pageTitle.getAttribute('jhiTranslate');
    }

    async setRateInput(rate) {
        await this.rateInput.sendKeys(rate);
    }

    async getRateInput() {
        return this.rateInput.getAttribute('value');
    }

    async setCityInput(city) {
        await this.cityInput.sendKeys(city);
    }

    async getCityInput() {
        return this.cityInput.getAttribute('value');
    }

    async setAddressInput(address) {
        await this.addressInput.sendKeys(address);
    }

    async getAddressInput() {
        return this.addressInput.getAttribute('value');
    }

    getStatusInput() {
        return this.statusInput;
    }
    async setMatchtimeInput(matchtime) {
        await this.matchtimeInput.sendKeys(matchtime);
    }

    async getMatchtimeInput() {
        return this.matchtimeInput.getAttribute('value');
    }

    async sportSelectLastOption() {
        await this.sportSelect
            .all(by.tagName('option'))
            .last()
            .click();
    }

    async sportSelectOption(option) {
        await this.sportSelect.sendKeys(option);
    }

    getSportSelect(): ElementFinder {
        return this.sportSelect;
    }

    async getSportSelectedOption() {
        return this.sportSelect.element(by.css('option:checked')).getText();
    }

    async save() {
        await this.saveButton.click();
    }

    async cancel() {
        await this.cancelButton.click();
    }

    getSaveButton(): ElementFinder {
        return this.saveButton;
    }
}
