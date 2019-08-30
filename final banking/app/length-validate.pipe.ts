import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'lengthValidate'
})
export class LengthValidatePipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    var result:string="";
    var i=value.length;
    if(i!=10){
      result="Phone Number must be 10 digits.!"
    }
    return result;
  }
  }

