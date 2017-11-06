import { RLibraryNGPage } from './app.po';

describe('rlibrary-ng App', () => {
  let page: RLibraryNGPage;

  beforeEach(() => {
    page = new RLibraryNGPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
