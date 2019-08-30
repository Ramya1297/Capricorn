import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'passwordValidate'
})
export class PasswordValidatePipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    var result:string="";
    var i=value.length;
    if(i<6 && i!=0){
      result="length must be atleast 6 ";
    }
   
    return result;
  }
}
