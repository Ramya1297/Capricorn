import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'validateAccount'
})
export class ValidateAccountPipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    var result:string="";
    var i=value.length;
    if(i!=10){
      result="Account number must be 10 digits.!"
    }
    return result;
  }

}
