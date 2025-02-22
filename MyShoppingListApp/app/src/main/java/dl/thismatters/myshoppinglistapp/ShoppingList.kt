package dl.thismatters.myshoppinglistapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.sin

data class ShoppingItem(val id:Int,
                        var name:String,
                        var quantity:Int,
                        var isEditing:Boolean = false
){

}

@Composable
fun ShoppingListApp(){
    var sItems by remember{ mutableStateOf(listOf<ShoppingItem>()) }
    var showDialog by remember { mutableStateOf(false) }
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }


    ///Lazy Column and Add Item Button
    Column(
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { showDialog = true },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text ="Add Item")
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ){
            items(sItems){
                item ->
                if (item.isEditing){
                    ShoppingItemEditor(item = item,
                        OnEditComplete = {
                            editedName , editedQuantity ->
                            sItems = sItems.map { it.copy(isEditing = false) }
                            val editedItem = sItems.find { it.id == item.id }
                            editedItem?.let{
                                it.name = editedName
                                it.quantity = editedQuantity
                        }
                        }
                    )
                }else{
                    ShoppingListItem(item = item,
                        OnEditClick = {
                            sItems = sItems.map { it.copy(isEditing = it.id==item.id)
                            }
                    }, OnDeleteClick = {
                        sItems = sItems - item
                    })
                }
            }
        }
    }

    ///Alert Dialog
    if (showDialog){
      AlertDialog(onDismissRequest = {showDialog = false },
          confirmButton = {
              Row(modifier = Modifier
                  .fillMaxWidth()
                  .padding(8.dp),
                  horizontalArrangement = Arrangement.SpaceBetween) {
                  Button(onClick = {
                      if (itemName.isNotBlank()){
                          val newItem = ShoppingItem(
                              id = sItems.size + 1,
                                name = itemName,
                              quantity = itemQuantity.toInt()
                          )
                          sItems = sItems + newItem
                          showDialog= false
                          itemName = ""
                      }
                  }) {
                      Text(text = "Add")
                  }
                  Button(onClick = { showDialog = false }) {
                      Text(text = "Cancel")
                  }
              }
          },
          title = { Text("Add Shopping Item")},
          text = {
              Column {
                  OutlinedTextField(
                      value = itemName,
                      onValueChange = {itemName = it},
                      singleLine = true,
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(8.dp)
                  )
                  OutlinedTextField(
                      value = itemQuantity,
                      onValueChange = {itemQuantity = it},
                      singleLine = true,
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(8.dp)
                  )
              }
          }
      )
    }

}


//When Edit Button Clicked
@Composable
fun ShoppingItemEditor(item: ShoppingItem, OnEditComplete: (String,Int) -> Unit){
    var editedName by remember { mutableStateOf(item.name)}
    var editedQuantity by remember { mutableStateOf(item.quantity.toString())}
    var isEditing by remember { mutableStateOf(item.isEditing) }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
        )
    {
        Column{
            BasicTextField(
                value = editedName,
                onValueChange = { editedName = it },
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
            BasicTextField(
                value = editedQuantity,
                onValueChange = { editedQuantity = it },
                singleLine = true,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(8.dp)
            )
        }
        
        Button(onClick = {
            isEditing = false
            OnEditComplete(editedName,editedQuantity.toIntOrNull() ?: 1)
        }) {
            Text(text = "Save")
        }
    }


}

//Shopping Item Added, List of Items
@Composable
fun ShoppingListItem(
    item: ShoppingItem,
    OnEditClick: () -> Unit,
    OnDeleteClick: () -> Unit,
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(
                border = BorderStroke(2.dp, Color.Green),
                shape = RoundedCornerShape(20)
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ){
        Text(text = item.name, modifier = Modifier.padding(8.dp))
        Text(text = "Qty : ${ item.quantity }",modifier = Modifier.padding(8.dp))
        Row (
            modifier = Modifier.padding(8.dp)
            ){
            IconButton(onClick = OnEditClick) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = null)
            }

            IconButton(onClick = OnDeleteClick) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = null)
            }
        }
    }
}