import { PasswordValidatePipe } from './password-validate.pipe';

describe('PasswordValidatePipe', () => {
  it('create an instance', () => {
    const pipe = new PasswordValidatePipe();
    expect(pipe).toBeTruthy();
  });
});
