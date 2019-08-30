import { ValidateAccountPipe } from './validate-account.pipe';

describe('ValidateAccountPipe', () => {
  it('create an instance', () => {
    const pipe = new ValidateAccountPipe();
    expect(pipe).toBeTruthy();
  });
});
