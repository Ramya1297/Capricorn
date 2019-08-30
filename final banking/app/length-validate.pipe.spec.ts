import { LengthValidatePipe } from './length-validate.pipe';

describe('LengthValidatePipe', () => {
  it('create an instance', () => {
    const pipe = new LengthValidatePipe();
    expect(pipe).toBeTruthy();
  });
});
