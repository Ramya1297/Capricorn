import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'checkMatch'
})
export class CheckMatchPipe implements PipeTransform {

  transform(value: any, ...args: any[]): any {
    var result:string="";
    var a=value.value;
   //console.log(a);

      if(a!=args[0] && args[0]!="" && a!="")
    result="Not Matched";
    return result;
  }
}