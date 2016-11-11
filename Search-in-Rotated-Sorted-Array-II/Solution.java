public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0){
            return false;
        }
        
        int start = 0;
        int end = A.length - 1;
        
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            
            if(A[mid] < A[end]){
                if(target > A[mid] && target < A[end]){
                    start = mid;
                }else if(target < A[mid]){
                    end = mid;
                }else if(target > A[start]){
                    end = mid;
                }else{
                    return true;
                }
            }else if(A[mid] > A[start]){
                if(target < A[mid] && target > A[start]){
                    end = mid;
                } else if(target > A[mid]){
                    start = mid;
                }else if(target < A[start]){
                    start = mid;
                }else{
                    return true;
                }
               //444514
            }else if(A[mid] == A[end] && A[mid] == A[start]){
                boolean decide = false;
                  for(int i = mid;  i < end; i++){
                      if(A[i] < A[mid]){
                          decide = true;
                          break;
                      }else{
                          decide = false;
                      }
                  }
                  if(decide){
                      if(target < A[mid]){
                          start = mid;
                      }else if(target > A[mid]){
                          start = mid;
                      }else{
                          return true;
                      }
                  }else{
                      if(target < A[mid]){
                          end = mid;
                      }else if(target > A[mid]){
                          end = mid;
                      }else{
                          return true;
                      }
                  }
                  
                  
                  
                 //45551111  
            }else if(A[mid] ==A[end]){
                if(target > A[mid]){
                    end = mid;
                }else if(target < A[mid]){
                    end = mid;
                }else{
                    return true;
                }
            
                //22231
            }else{
                if(target > A[mid]){
                    start = mid;
                }else if(target < A[mid]){
                    start = mid;
                }else{
                    return true;
                }
            }
            
        }
        if(A[start] == target || A[end] == target){
            return true;
        }else{
            return false;
        }
    }
}
