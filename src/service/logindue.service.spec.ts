import { TestBed } from '@angular/core/testing';

import { LogindueService } from './logindue.service';

describe('LogindueService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LogindueService = TestBed.get(LogindueService);
    expect(service).toBeTruthy();
  });
});
